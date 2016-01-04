document.getElementById('openCamera').addEventListener('click', function(){
    _jsTunnel.exec("camera", "openCamera", "[]");
});
document.getElementById('toast').addEventListener('click', function(){
    _jsTunnel.exec("toast", "show", "[hello,html]");
});