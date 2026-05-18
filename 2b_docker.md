# Docker Setup Guide

## Step 1: Create the Project Files
1. Create a new folder named `app` for your project and open it in VS Code.
2. Create a file named `index.js` and add some simple Node.js code:
```javascript
const http = require('http');

const server = http.createServer((req, res) => {
  res.end('World\n');
});

server.listen(80);
```

3. Create a file named `Dockerfile` (no extension) and add the following content:
```dockerfile
FROM node:alpine
COPY . /app
CMD node /app/index.js
```

## Step 2: Setup & Execution Commands
Open your terminal in VS Code and run these commands in order:

**1. Build the Docker image** (Builds the image using the Dockerfile in the current folder)
```bash
docker build -t app .
```

**2. Run the Docker container** (Starts the container in background and maps ports if it's a web server)
```bash
docker run -d -p 8080:80 app
```

## Step 3: How to View Your Work
If your app is a web server, once you run the container, open your browser and go to:
[http://localhost:8080](http://localhost:8080)

## Extra Commands

**1. Verify image creation** (Checks that your image was created successfully)
```bash
docker images
```

**2. Check running containers** (Verifies if the container is currently running)
```bash
docker ps
```

**3. Stop the container** (Stops the running container using its ID from the previous step)
```bash
docker stop <container_id>
```


