// https://juso.dev/docs/reg-code-api/
$(function () {
    for (let i = 2000; i < 2023; i++) {
        $("#year").append(`<option value="${i}">${i}년</option>`);
    }

    for (let i = 1; i < 13; i++) {
        $("#month").append(`<option value="${i < 10 ? "0" + i : i}">${i}월</option>`);
    }

    sendRequest("sido", "*00000000");
});

$(document).on("change", "#sido", function () {
    regcode = $(this).val().substr(0, 2) + "*00000";
    console.log("sido select regcode : " + regcode);
    $("#gugun").empty();
    $("#dong").empty().append("<option>동선택</option>");
    sendRequest("gugun", regcode);
});

$(document).on("change", "#gugun", function () {
    regcode = $(this).val().substr(0, 5) + "*";
    console.log("gugun select regcode : " + regcode);
    sendRequest("dong", regcode);
});

function sendRequest(selid, regcode) {
    console.log("regcode : " + regcode);
    $.ajax({
        url: "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes",
        type: "GET",
        data: {
            regcode_pattern: regcode,
            is_ignore_zero: true,
        },
        dataType: "json",
        success: function (response) {
            console.log(response);
            addOption(selid, response);
        },
        error: function (xhr, status, msg) {
            console.log("상태값 : " + status + " Http에러메시지 : " + msg);
        },
    });
}

function addOption(selid, data) {
    let code = ``;
    let initOption = ``;
    switch (selid) {
        case "sido":
            initOption = `<option>시도선택</option>`;
            $("#sido").empty().append(initOption);
            $.each(data.regcodes, function (i, regcode) {
                code += `
        <option value="${regcode.code}">${regcode.name.split(" ")[0]}</option>
        `;
            });
            break;
        case "gugun":
            initOption = `<option>구군선택</option>`;
            $("#gugun").empty().append(initOption);
            console.log(data.regcodes);
            for (let i = 0; i < data.regcodes.length; i++) {
                if (i != data.regcodes.length - 1) {
                    if (
                        data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
                        data.regcodes[i].name.split(" ").length !=
                        data.regcodes[i + 1].name.split(" ").length
                    ) {
                        data.regcodes.splice(i, 1);
                        i--;
                    }
                }
            }
            console.log(data.regcodes);
            let name = "";
            $.each(data.regcodes, function (i, regcode) {
                if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
                else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
                code += `
        <option value="${regcode.code}">${name}</option>
        `;
            });
            break;
        case "dong":
            initOption = `<option>동선택</option>`;
            $("#dong").empty().append(initOption);
            let idx = 2;
            $.each(data.regcodes, function (i, regcode) {
                if (data.regcodes[i].name.split(" ").length != 3) idx = 3;
                code += `
        <option value="${regcode.code}">${regcode.name.split(" ")[idx]}</option>
        `;
            });
            break;
    }
    $("#" + selid).append(code);
}

$(document).on("click", "#btn-list", function () {
    let gugun = $("#gugun").val().substr(0, 5);
    let ym = "" + $("#year").val() + $("#month").val();
    console.log(gugun + " " + ym);
    let requestData = {
        serviceKey:
            "9Xo0vlglWcOBGUDxH8PPbuKnlBwbWU6aO7+k3FV4baF9GXok1yxIEF+Iwr2+//4oVLT8bekKU+k9ztkJO0wsBw==",
        pageNo: "1",
        numOfRows: "30",
        LAWD_CD: gugun,
        DEAL_YMD: ym,
    };
    $.ajax({
        url: "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev",
        type: "GET",
        data: requestData,
        dataType: "xml",
        success: function (response) {
            console.log(response);
            makeList(response);
        },
        error: function () { },
    });
});

function makeList(data) {
    let aptListInfo = ``;
    $(data)
        .find("item")
        .each(function () {
            aptListInfo += `
        <tr>
            <td>${$(this).find("아파트").text()}</td>
            <td>${$(this).find("층").text()}</td>
            <td>${$(this).find("전용면적").text()}</td>
            <td>${$(this).find("법정동").text()}</td>
            <td>${$(this).find("거래금액").text()}</td>
        </tr>
        `;
        });
    $("#aptlist").empty().append(aptListInfo);
    $("tr:first").css("background", "black").css("color", "white");
    $("tr:odd").css("background", "lightgray");
}