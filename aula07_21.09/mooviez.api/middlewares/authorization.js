const fs = require("fs");
const { sign, verify } = require("jsonwebtoken");
const userdb = JSON.parse(fs.readFileSync("./users.json", "UTF-8"));

const SECRET_KEY = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
const expiresIn = "1h";

const createToken = (payload) => sign(payload, SECRET_KEY, { expiresIn });

const verifyToken = (token) =>
  verify(token, SECRET_KEY, (err, decode) =>
    decode !== undefined ? decode : err
  );

const isAuthenticated = ({ email, password }) =>
  userdb.users.findIndex(
    (user) => user.email === email && user.password === password
  ) !== -1;

module.exports = { createToken, verifyToken, isAuthenticated };
