# jQuery Mobile Application Setup

## Step 1: Create the Mobile Dashboard (Basic Structure)
1. Create a folder for your jQuery project in VS Code.
2. Inside that folder, create a file named `mobile_dashboard.html`.
3. Copy and paste the following code into `mobile_dashboard.html`:

```html
<!DOCTYPE html>
<html>
<head>
    <title>My Mobile Site</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>

    <div data-role="page" id="home">
        
        <div data-role="header">
            <h1>Mobile Admin</h1>
        </div>

        <div data-role="main" class="ui-content">
            <p>Welcome to the jQuery Mobile Dashboard.</p>
            <a href="#details" class="ui-btn ui-btn-b">View Statistics</a>
            <a href="#" class="ui-btn ui-corner-all">Manage Orders</a>
        </div>

        <div data-role="footer">
            <h4>&copy; 2026 Admin Panel</h4>
        </div>
    </div>

    <div data-role="page" id="details">
        <div data-role="header">
            <a href="#home" class="ui-btn ui-icon-home ui-btn-icon-left">Home</a>
            <h1>Statistics</h1>
        </div>
        <div data-role="main" class="ui-content">
            <ul data-role="listview" data-inset="true">
                <li>Total Sales: $10,000</li>
                <li>Active Users: 450</li>
                <li>Pending Tasks: 5</li>
            </ul>
        </div>
    </div>

</body>
</html>
```

## Step 2: Create the Student Registration App (Advanced Example)
1. In the same folder, create another file named `student_registration.html`.
2. Copy and paste the following code into `student_registration.html`:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration App</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- jQuery Mobile -->
    <link rel="stylesheet"
    href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">

    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

    <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>

<body>

<!-- First Page -->
<div data-role="page" id="page1">

    <div data-role="header" data-theme="b">
        <h1>Student Registration</h1>
    </div>

    <div data-role="content">

        <label>Name:</label>
        <input type="text" id="name" placeholder="Enter Name">

        <label>Email:</label>
        <input type="email" id="email" placeholder="Enter Email">

        <label>Course:</label>
        <select id="course">
            <option>BCA</option>
            <option>BTech</option>
            <option>MCA</option>
        </select>

        <button onclick="showData()" data-theme="b">
            Register
        </button>

    </div>

</div>

<!-- Second Page -->
<div data-role="page" id="page2">

    <div data-role="header" data-theme="b">
        <h1>Registration Details</h1>
    </div>

    <div data-role="content">

        <h3 id="output"></h3>

        <a href="#page1" data-role="button" data-theme="a">
            Back
        </a>

    </div>

</div>

<script>

function showData()
{
    var name = $("#name").val();
    var email = $("#email").val();
    var course = $("#course").val();

    $("#output").html(
        "Name : " + name + "<br><br>" +
        "Email : " + email + "<br><br>" +
        "Course : " + course
    );

    $.mobile.changePage("#page2");
}

</script>

</body>
</html>
```

## Step 3: Run the Application
1. Right-click on either `mobile_dashboard.html` or `student_registration.html` in your VS Code explorer.
2. Select **Open with Live Server** (if you have the extension installed) or simply double-click the file to open it directly in your web browser.