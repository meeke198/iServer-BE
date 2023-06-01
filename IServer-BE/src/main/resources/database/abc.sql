use `iserver-v1`;
INSERT INTO user (id, create_at, username, password, email, avatar, is_active, is_online)
VALUES (1, '2023-05-26 10:30:00', 'john_doe', 'abc123', 'john@example.com', 'avatar.jpg', 1, 1);
INSERT INTO user (id, create_at, username, password, email, avatar, is_active, is_online)
VALUES (2, '2023-05-26 11:15:00', 'jane_smith', 'password456', 'jane@example.com', 'user.png', 1, 1);
INSERT INTO user (id, create_at, username, password, email, avatar, is_active, is_online)
VALUES (3, '2023-05-26 12:00:00', 'michael_johnson', 'pass789', 'michael@example.com', 'default.jpg', 0, 1);
INSERT INTO user (id, create_at, username, password, email, avatar, is_active, is_online)
VALUES (4, '2023-05-26 13:30:00', 'hiennguyen', 'qwerty', 'longusername@example.com', 'user.jpg', 1, 1);
INSERT INTO user (id, create_at, username, password, email, avatar, is_active, is_online)
VALUES (5, '2023-05-26 14:45:00', 'emma_smith', 'password123', 'emma@example.com', 'user2.jpg', 1, 1);
select * from user;
INSERT INTO room (id, name, create_at)
VALUES (1, 'Meeting Room 1', '2023-05-26 10:30:00');
INSERT INTO room (id, name, create_at)
VALUES (2, 'Conference Room', '2023-05-26 11:15:00');
INSERT INTO room (id, name, create_at)
VALUES (3, NULL, '2023-05-26 11:15:00');
INSERT INTO room (id, name, create_at)
VALUES (4, 'Board Room', '2023-05-26 13:30:00');
INSERT INTO room (id, name, create_at)
VALUES (5, 'Training Room', '2023-05-26 13:30:00');
select * from room;
INSERT INTO room_user (id, name, room_id, user_id)
VALUES (1, 'John Doe', 2, 1);
INSERT INTO room_user (id, name, room_id, user_id)
VALUES (2, 'Jane Smith', 2, 3);
INSERT INTO room_user (id, name, room_id, user_id)
VALUES (3, 'abc', 1, 2);
INSERT INTO room_user (id, name, room_id, user_id)
VALUES (4, 'Michael Johnson', 3, 1);
INSERT INTO room_user (id, name, room_id, user_id)
VALUES (5,'Emma Thompson', 2, 2);
select * from room_user;
INSERT INTO message (id, content, user_id, room_id, sent_at)
VALUES (1, 'Hello everyone!', 1, 1, '2023-05-26 10:30:00');
INSERT INTO message (id, content, user_id, room_id, sent_at)
VALUES (2, 'Welcome to the room!', 2, 3, '2023-05-26 11:15:00');
INSERT INTO message (id, content, user_id, room_id, sent_at)
VALUES (3, 'hihi', 1, 2, '2023-05-26 13:30:00');
INSERT INTO message (id, content, user_id, room_id, sent_at)
VALUES (4, 'Goodbye!', 3, 1, '2023-05-26 13:30:00');
INSERT INTO message (id, content, user_id, room_id, sent_at)
VALUES (5, 'How are you?', 2, 2, '2023-05-26 13:30:00');
select * from message;



