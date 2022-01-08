CREATE TABLE IF NOT EXISTS user_profile
(
    discord_id  varchar(255)    PRIMARY KEY,
    nome            VARCHAR (100)   NOT NULL,
    discord_tag     VARCHAR (100)   NOT NULL,
    registered_at   TIMESTAMP default now() NOT NULL,
    general_password VARCHAR (500)
);

CREATE TABLE IF NOT EXISTS guild
(
    guild_id        VARCHAR(50)        PRIMARY KEY,
    guild_name      VARCHAR (100)      NOT NULL
);

CREATE TABLE IF NOT EXISTS user_guild
(
    user_guild_id   VARCHAR(50)      PRIMARY KEY,
    is_admin        BOOL DEFAULT FALSE  NOT NULL,
    status          VARCHAR (20)        NOT NULL,
    guild_id        VARCHAR (20)        NOT NULL,
    discord_id      VARCHAR (50)        NOT NULL,
    CONSTRAINT guild_id
        FOREIGN KEY (guild_id) REFERENCES guild(guild_id),
    CONSTRAINT discord_id
        FOREIGN KEY (discord_id) REFERENCES user_profile(discord_id)
);

CREATE TABLE IF NOT EXISTS private_channel
(
  private_channel_id    VARCHAR(100)    PRIMARY KEY,
  password              VARCHAR(500),
  user_id               VARCHAR(20)     NOT NULL,
  guild_id              VARCHAR(20)     NOT NULL,
  CONSTRAINT user_id
      FOREIGN KEY (user_id) REFERENCES user_profile(discord_id),
  CONSTRAINT guild_id
      FOREIGN KEY (guild_id) REFERENCES guild(guild_id)
);

CREATE SEQUENCE IF NOT EXISTS sequence_user_guild
    START WITH 1;
