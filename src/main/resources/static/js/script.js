$(document).ready(function () {
    $('.switch button').click(function () {
        var button = $(this);
        var id = button.attr('data-id');
        var url = "/api/switch/" + id + "/toggle";
        $.get(url, function (data) {
            if (data == 1) {
                button.removeClass('off');
                button.addClass('on');
            } else if (data == 0) {
                button.removeClass('on');
                button.addClass('off');
            }
        });
    });
    $('.rgb-led button').click(function () {
//        alert('rgb-led');
    });

    $('.rgb-led input').click(function(){
        var button = $(this);
        var id = button.attr('data-id');
        $('#currently_clicked').val(id);
    });

});

function update(jscolor) {
    var red = Math.round(jscolor.rgb[0]);
    var green = Math.round(jscolor.rgb[1]);
    var blue = Math.round(jscolor.rgb[2]);

    var currentlyClickedHolder = document.getElementById('currently_clicked');
    var id = currentlyClickedHolder.value;

    var button = $(this);
    var url = "/api/rgbled/" + id + "/" + red + '/'+green+'/'+blue;
    $.get(url, function (data) {
        console.log(id+":"+red+'x'+green+'x'+blue);
    });
}