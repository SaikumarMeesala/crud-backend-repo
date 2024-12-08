# Step 1: Build the React app
FROM node:16-alpine as build

# Set working directory
WORKDIR /app

# Install dependencies and build the app
COPY package.json package-lock.json ./
RUN npm install
COPY . ./
RUN npm run build

# Step 2: Serve the React app using Nginx
FROM nginx:alpine

# Copy the build files from the previous stage
COPY --from=build /app/build /usr/share/nginx/html

# Expose the port that Nginx serves the app on
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
