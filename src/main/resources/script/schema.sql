CREATE DATABASE basic_rest_api_2;

CREATE TABLE venues
(
    venue_id   SERIAL PRIMARY KEY,
    venue_name varchar(70) NOT NULL,
    location   point       NOT NULL
);

CREATE TABLE events
(
    event_id SERIAL PRIMARY KEY ,
    event_name VARCHAR(70) NOT NULL ,
    event_date DATE NOT NULL,
    venue_id INT NOT NULL,

    FOREIGN KEY (venue_id) REFERENCES venues (venue_id)
);

CREATE TABLE attendees
(
    attendee_id SERIAL PRIMARY KEY ,
    attendee_name VARCHAR(70) NOT NULL ,
    email VARCHAR(70) NOT NULL
);

CREATE TABLE event_attendee
(
    attendee_id INT NOT NULL ,
    event_id INT NOT NULL ,

    FOREIGN KEY (attendee_id) REFERENCES attendees (attendee_id),
    FOREIGN KEY (event_id) REFERENCES events (event_id),
    PRIMARY KEY (attendee_id, event_id)
);
