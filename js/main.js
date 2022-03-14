
function search() {
let searchVal = `${$('#sido option:selected').text()}${$('#gugun option:selected').text()}${$('#dong option:selected').text()}`;
    console.log(searchVal);
}

function login() {
    let email = document.getElementById('email').value;
    let password = document.getElementById('pwd').value;

    // user 생성
    const user = {
        email: email,
        password: password,
    };

    // user 정보 출력
    console.log(user);
    console.log('login');

    localStorage.email = email;
    localStorage.password = password;
}

function logout() {
    console.log('clear');
    localStorage.clear();
}

function signOut() {
    alert('사이트 탈퇴를 신청하시겠습니까?');   
}

function update() {
    $('#mod-pwd').attr('readonly', false);
    $('#update-btn').hide();
    $('#signOut-btn').hide();

    document.getElementById('save-btn').style.display = '';
}

function save() {
    confirm('저장하시겠습니까?');
    let password = document.getElementById('mod-pwd').value;
    localStorage.password = password;
}

function initializeModal() {
    // $('.modal-body input').attr('disabled', true);
    $('#update-btn').show();
    $('#signOut-btn').show();
}

$(function () {
    $('#search-btn').on('click', search);
    $('#btn-login').on('click', login);
    $('#logout').on('click', logout);

    // 로그인/로그아웃 상태 확인
    if (localStorage.email != null) {
        document.getElementById('login').style.display = 'none';
        document.getElementById('logout').style.display = '';
        document.getElementById('accountInfo-btn').style.display = '';

        console.log('email : ' + localStorage.email);
        console.log('pw : ' + localStorage.password);
        console.log('login');

        document.getElementById('mod-email').value = localStorage.email;
        document.getElementById('mod-pwd').value = localStorage.password;
    } else {
        console.log('logout');
    }
    $('#signOut-btn').on('click', signOut);
    $('#update-btn').on('click', update);
    $('#save-btn').on('click', save);
    $('#accountInfo-btn').on('click', initializeModal);
});