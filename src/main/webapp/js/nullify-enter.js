document.getElementById("form1").onkeypress = (e) => {
    // form1に入力されたキーを取得
    const key = e.keyCode || e.charCode || 0;
    // 13はEnterキーのキーコード
    if (key == 13) {
        // アクションを行わない
        e.preventDefault();
    }
}

//送信ボタンを押した際に送信ボタンを無効化する（連打による多数送信回避）
$(function(){
    $('[type="submit"]').click(function(){
        $(this).prop('disabled',true);//ボタンを無効化する
        $(this).closest('form').submit();//フォームを送信する
    });
});
