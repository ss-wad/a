## display.html

```html
<!DOCTYPE html>
<html>
<head><title>User List</title></head>
<body>
    <h2>Registered Users</h2>
    <ul id="userList"></ul>
    <script>
        let users = JSON.parse(localStorage.getItem("users")) || [];
        let list = document.getElementById("userList");
        
        // users.forEach(user => {
        //     list.innerHTML += `<li>${user.name} - ${user.email}</li>`;
        // });
        for(let i = 0; i < users.length; i++) {
            list.innerHTML += users[i].name + " - " + users[i].email + "<br>";
        }
    </script>
    <a href="index.html">Back to Register</a>
</body>
</html>
```

## index.html

```html
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h2>Register User</h2>
    <form id="regForm">
        <input type="text" id="name" placeholder="Enter Name" required><br><br>
        <input type="email" id="email" placeholder="Enter Email" required><br><br>
        <button type="submit">Submit via AJAX</button>
    </form>

    <script>
        $(document).ready(function() {
            $("#regForm").submit(function(e) {
                e.preventDefault(); // Prevent page reload

                let userData = {
                    name: $("#name").val(),
                    email: $("#email").val()
                };

                // Simulate AJAX POST 
                $.ajax({
                    type: "POST",
                    url: "https://jsonplaceholder.typicode.com/posts", // Fake API for testing
                    data: userData,
                    success: function() {
                        // 1. Get existing data from localStorage or start new array
                        let users = JSON.parse(localStorage.getItem("users")) || [];
                        
                        // 2. Push new data to array
                        users.push(userData);
                        
                        // 3. Save back to localStorage
                        localStorage.setItem("users", JSON.stringify(users));

                        alert("Registration Successful!");
                        
                        // 4. Redirect to show the list
                        window.location.href = "display.html"; 
                    }
                });
            });
        });
    </script>
</body>
</html>
```
