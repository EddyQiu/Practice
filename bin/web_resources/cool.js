console.log("hello world");

$(document).ready(function () {
    $('.testbutton').click(function (event) {
        var name=$('.name').val();
        var type=$('.type').val();
        var level=$("input[name='Level']:checked").val();
        console.log(level.val);
        
        if(level.val == "1"){
            console.log("1");
        }
        else if(level.val == "2"){
            console.log("2");
        }
        else{
            console.log("3");
        }
    })
})



