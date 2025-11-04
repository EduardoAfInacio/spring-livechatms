## spring-livechatms

Example project demonstrating a simple real-time chat built with Java and Spring Boot, using WebSocket on the backend and a small static frontend that uses jQuery for user interaction.

The goal of this repository is to provide a compact, practical reference for integrating WebSockets into a Spring Boot application and to offer a lightweight HTML/JavaScript interface for testing and demonstration.

## Overview

- Main feature: real-time live chat between clients using WebSocket.
- Lightweight frontend served from `src/main/resources/static` (includes `index.html`, `app.js`, and `main.css`).
- Java backend with Spring Boot and WebSocket configuration in `config/WebSocketConfig.java` and controller `controller/LiveChatController.java`.
- Simple domain objects for message input and output: `domain/ChatInput.java` and `domain/ChatOutput.java`.

## Technologies

- Java 17
- Spring Boot (Web, WebSocket)
- Spring Messaging / STOMP (if enabled by the WebSocket configuration)
- jQuery (used in the static frontend for DOM manipulation and event handling)
- HTML, CSS and JavaScript for the lightweight client
- Maven (wrapper included: `mvnw` and `mvnw.cmd`)

Note: the project is intentionally small — its purpose is to demonstrate the flow of a real-time chat application without unnecessary complexity.

## Project structure (high level)

- `src/main/java/com/eduardoinacio/spring_livechatms/` — application Java code
  - `config/` — WebSocket configuration (`WebSocketConfig.java`)
  - `controller/` — controller handling chat messages (`LiveChatController.java`)
  - `domain/` — domain classes for messages (`ChatInput`, `ChatOutput`)
- `src/main/resources/static/` — static frontend
  - `index.html` — main chat page
  - `app.js` — JavaScript logic that uses jQuery to manage the UI and connect to the WebSocket
  - `main.css` — basic styles

## How WebSocket is used

The backend exposes a WebSocket endpoint configured in `WebSocketConfig.java`. The typical flow is:

1. The client (JavaScript in `app.js`) establishes a WebSocket connection (it may use SockJS/STOMP depending on the project configuration).
2. The user sends messages via the page form; `app.js` captures the submit using jQuery and sends the message through the WebSocket.
3. The `LiveChatController` on the server receives the message, applies any needed logic (for example, add timestamp, author or minimal validation) and publishes the message to other connected clients.
4. Clients receive messages in real time and `app.js` updates the message list in the page.

This architecture enables low-latency, bidirectional communication between clients and server without polling.

## Role of jQuery

- jQuery is used in the frontend to simplify DOM manipulation (append messages, clear form fields, handle click/submit events).
- The use of jQuery keeps the frontend small and easy to follow — this demo does not use a full SPA framework.

## Requirements

- JDK 17
- Maven (or use the included wrappers `mvnw` / `mvnw.cmd`)
- A modern browser to access the static interface

## Run locally (Windows)

1. Build the project:

```powershell
.\mvnw.cmd clean package
```

2. Run the application:

```powershell
.\mvnw.cmd spring-boot:run
```

3. Open your browser and visit:

- http://localhost:8080/

Note: to run on Unix/macOS use the `./mvnw` wrapper instead.

## Testing the chat

1. Open two browser windows/tabs at `http://localhost:8080/`.
2. Enter a name in each and send messages. Messages should appear in real time on both tabs.

## Relevant files and endpoints

- WebSocket configuration: `src/main/java/.../config/WebSocketConfig.java`
- WebSocket controller: `src/main/java/.../controller/LiveChatController.java`
- Message DTOs: `src/main/java/.../domain/ChatInput.java` and `ChatOutput.java`
- Static frontend: `src/main/resources/static/index.html` and `app.js`

If you want the exact topic/endpoint names used by the WebSocket (for example `/app/chat` or `/topic/messages`), open `WebSocketConfig.java` and `LiveChatController.java` to see the concrete values — this README avoids hardcoding specific paths so it remains accurate if the configuration changes.

## License & contributions

This project is an educational example. Feel free to open issues or create pull requests with improvements.
