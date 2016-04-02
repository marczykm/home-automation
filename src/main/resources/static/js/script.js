$(document).ready(function () {
    $('.switch button').click(function () {
        var button = $(this);
        var id = button.attr('data-id');
        var url = "http://localhost:8080/api/switch/" + id + "/toggle";
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
        alert('rgb-led');
    });
});