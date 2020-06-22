function changeSecondOptions(options) {
    console.log("get response: " + options);
    for(let i = 0; i < options.length; i++) {
        options[i] = "<option>" + options[i] + "</option>";
    }
    $("second").html(options.join("\n"));
    document.getElementById("second").innerHTML = options.join("\n");
}

function checkCacheAndChange() {
    let first = document.getElementById("first");
    console.log(first.selectedIndex);
    if (cache[first.options[first.selectedIndex].text]===undefined) {
        $.ajax({
            // accepts: "*/*",
            url: "/2options",
            data: { "firstSelect" :first.options[first.selectedIndex].text} ,
            success: function (result) {
                changeSecondOptions(result);
            }
        }).done;
    }
    else {
         changeSecondOptions(cache[first.options[first.selectedIndex].text]);
    }
}

var cache = [];
function addListeners() {
    $("first").on("change", checkCacheAndChange);
    document.getElementById("first").addEventListener("change",checkCacheAndChange);
}
document.addEventListener("DOMContentLoaded", addListeners);
$(document).ready(addListeners);
