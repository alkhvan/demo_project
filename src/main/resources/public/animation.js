function myMove() {
    var elem = document.getElementById("pacman1");
    var pos = 0;
    var id = setInterval(frame, 10);
    function frame() {
        if (pos == 350) {
            clearInterval(id);
        } else {
            pos++;
            elem.style.top = pos + 'px';
            elem.style.left = pos + 'px';
        }
    }
}

//Animation
var input = document.getElementById("buttonHeart");
input.addEventListener("click",myMove);


