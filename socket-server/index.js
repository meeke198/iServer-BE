const express = require("express");
const app = express();
const http = require('http').Server(app);
const axios = require("axios");
// console.log(http);


const mongoose = require("mongoose");
const bodyParser = require("body-parser");

const db_url = "mongodb://localhost:27017/roomchat_kha_hien";

// require('./config/database'); //connect to database errors
//connect to MongoDB using Mongoose
mongoose
  .connect(db_url, { useNewUrlParser: true })
  .then(() => console.log("Connected to MongoDB successfully"))
  .catch((err) => console.log(err));

// const users = require("./routes/api/users");
// const users = require("./routes/api/messages");
// const users = require("./routes/api/conversations");
//“CORS” stands for Cross-Origin Resource Sharing. It allows you to make requests from one website to another website in the browser, which is normally prohibited by another browser policy called the Same-Origin Policy (SOP).
const cors = require("cors"); //enable cors
app.use(cors());
// const http = require("http");
// console.log(app);
// const io = require('socket.io')(8081, {
//   cors: {
//     origin: ['http://localhost:3000']
//   }
// })
const socketIo = require("socket.io")(http, {
  cors: {
    origin: "*",
  },
});
// By creating an HTTP server using http.createServer(app), you establish a foundation that allows Socket.IO to work with the HTTP server


require("dotenv").config(); //de doc duoc file env bang cach process.env.abc

const auth = require("./routes/api/auth");
//body request tu front end gui xuong se chay qua cai code nay de parse ve dang json
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// app.use("/api/auth", auth);
// app.use("/api/users", users);

// const io = socketio(server)
socketIo.on("connection", (socket) => {
  console.log(`New socket connection....${socket.id}`);
});

const port = process.env.PORT || 5000;
app.listen(port, () => console.log(`Server is running on port ${port}`));

//
// var express = require("express");
// const http = require("http");

// var app = express();
// const server = http.createServer(app);
// Long them vao bien leaveRoom vao luc 8:05
// const leaveRoom = require("./utils/leave_room");

// ===========================================
// const socketIo = require("socket.io")(server, {
//   cors: {
//     origin: "*",
//   },
// });
// nhớ thêm cái cors này để tránh bị Exception nhé :D  ở đây mình làm nhanh nên cho phép tất cả các trang đều cors được.

// let listUser = [];

// Quang them cac bien de dung cho chat 1-1
let rooms11 = [];

// Code by Long
let chatRoomUsers = [];
let usersList = [];
let roomsList = [];
let listMessage = [];
// ======================
axios
  .get("http://localhost:8081/rooms")
  .then((res) => {
    roomsList = res.data;
    // console.log(roomsList);
  })
  .catch((err) => {
    console.log(err);
    throw err;
  });

axios
  .get("http://localhost:8081/users")
  .then((res) => {
    usersList = res.data;
    // console.log(res.data);
  })
  .catch((err) => {
    console.log(err);
    throw err;
  });

// socketIo.on("connection", (socket) => {
//   console.log("New client connected " + socket.id);

//   socket.on("usersList", () => {
//     axios
//       .get("http://localhost:8081/users")
//       .then((res) => {
//         listUser = res.data;
//         console.log(res.data);
//       })
//       .catch((err) => {
//         console.log(err);
//         throw err;
//       });
//   });

  // socket.on("roomsList", () => {
  //   axios
  //     .get("http://localhost:8081/rooms")
  //     .then((res) => {
  //       roomsList = res.data;
  //       console.log(roomsList);
  //     })
  //     .catch((err) => {
  //       console.log(err);
  //       throw err;
  //     });
  // });

//   socketIo.sockets.emit("get_rooms", rooms);

//   socketIo.sockets.emit("set-list", listUser);

//   socket.on("send-rooms", function () {});

//   // axios
//   // .get("http://localhost:8081/roomList")
//   // .then((res) => {
//   //   rooms = res.data;
//   //   console.log(rooms);
//   //   socket.emit("get_room", rooms);
//   // })
//   // .catch((err) => {
//   //   console.log(err);
//   //   throw err;
//   // });

//   //Ben Chat.js khi user click vao avatar thi server tai vi tri nay se luu room 1-1
//   socket.on("join-room-11", (data) => {
//     let checkRoom = false;

//     rooms11.map((room) => {
//       if (
//         room.indexOf(data.username11) !== -1 &&
//         room.indexOf(data.clickedPerson) !== -1
//       ) {
//         socket.join(room);
//         checkRoom = true;
//         socket.emit("send-room-exist", room);
//       }
//     });

//     if (!checkRoom) {
//       rooms11.push(data.room);
//       socket.join(data.room);
//       socket.emit("send-room-new", data.room);
//     }
//   });

//   socket.on("get-message", (data) => {
//     axios
//       .get(`http://localhost:8081/message-history/${data}`)
//       .then((res) => {
//         listMessage = res.data;
//         console.log(listMessage);
//         socket.emit("sendMessFromRoom", listMessage);
//       })
//       .catch((err) => {
//         console.log(err);
//         throw err;
//       });
  // });

//   socket.on("logout", (data) => {
//     console.log(data.username);
//     axios.post(`http://localhost:8081/logout/${data}`).catch((err) => {
//       console.log(err);
//       throw err;
//     });

//     listUser.splice(listUser.indexOf(data), 1);
//     socket.broadcast.emit("getlist", listUser);
//   });

//   socket.on("disconnect", () => {
//     // listUser.splice(listUser.indexOf(socket.UserName), 1);
//     // socket.broadcast.emit("getlist", listUser);
//     console.log(socket.id + " disconnected");
//   });

//   // Long Chat room socket
//   // Chat Room =====================================================
//   socket.on("join_chat", (data) => {
//     const { username, room } = data;
//     socket.join(room);
//     allUsers.push({ id: socket.id, username, room });
//     console.log(allUsers);
//   });

//   // sendDataClient dang duoc su dung o tren, Long doi ten lai de ko bi conflict!
//   // Long 7:57AM da sua ten ========================
//   socket.on("sendDataFromRoom", (data) => {
//     const { content, username, room_name, date } = data;
//     axios
//       .post("http://localhost:8081/message", data)
//       .then((res) => {
//         console.log(data);
//       })
//       .catch((err) => {
//         console.log(err);
//         throw err;
//       });

//     socketIo.in(room_name).emit("sendDataToRoom", data);
//     // console.log(data);
//   });
//   // ==============================

//   // Long addRoom socket
//   socket.on("add_room", (data) => {
//     socket.room = data;
//     socket.join(data);
//     axios
//       .post(`http://localhost:8081/room/${data}`)
//       .then((res) => {
//         rooms.push(data);
//       })
//       .catch((err) => {
//         console.log(err);
//         throw err;
//       });
//   });

//   socket.on("getRooms", () => {
//     socket.emit("get_rooms", rooms);
//     // console.log(rooms)
//   });

//   socket.on("leave_room", (data) => {
//     const { username, room } = data;
//     socket.leave(room);
//   });

//   socket.on("disconnect", (data) => {
//     console.log("disconnect" + socket.id);
//   });
//   // Long end========================================================
// });

// server.listen(3001, () => {
//   console.log("Server đang chay tren cong 3001");
// });
