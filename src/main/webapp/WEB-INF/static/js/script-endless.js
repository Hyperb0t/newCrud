document.addEventListener("DOMContentLoaded", addListeners);
var userPageNumber = 1;
var loading = false;
function addListeners() {
    // $(window).on('scroll', checkScroll);
    window.addEventListener("scroll", checkScroll);
}

function checkScroll() {
    console.log("scrolling");
    console.log(window.innerHeight + window.scrollY);
    console.log(document.body.offsetHeight-100);
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight-100) {
        console.log("loading users");
        loadUsers()
    }
}

function loadUsers() {
    if(!loading) {
        loading = true;
        $.ajax({
            url: "/userlist/endless-api",
            data: {"page": userPageNumber},
            success: function (result) {
                userPageNumber += 1;
                addUsersToDOM(result);
            }
        });
    }
}

function addUsersToDOM(users) {
    for(let i = 0; i < users.length; i++) {
        // users[i] = "<tr>" + JSON.stringify(users[i]) +"</tr>";
        users[i] = "<tr style=\"height: 200px\">" +
            "<td>" + users[i]["id"] + "</td>" +
            "<td>" + users[i]["email"] + "</td>" +
            "<td>" + users[i]["password"] + "</td>" +
            "<td>" + users[i]["country"] + "</td>" +
            "<td>" + users[i]["gender"] + "</td>" +
            "<td>" + JSON.stringify(users[i]["birthday"]) + "</td>" +
            "</tr>";
    }
    document.getElementById("userlist").innerHTML =
        document.getElementById("userlist").innerHTML + users.join("\n");
    loading = false;
}

