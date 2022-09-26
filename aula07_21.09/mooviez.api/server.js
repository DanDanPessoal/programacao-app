const { create, router: _router, defaults } = require("json-server");
const server = create();
const router = _router("db.json");
const middlewares = defaults();
const bodyParser = require("body-parser");
const {
  isAuthenticated,
  verifyToken,
  createToken,
} = require("./middlewares/authorization");

server.use(middlewares);
server.use(bodyParser.urlencoded({ extended: true }));
server.use(bodyParser.json());

server.post("/auth/login", (req, res) => {
  if (!req.body) {
    const status = 400;
    const message = "Valores inválidos para email e senha";
    res.status(status).json({ status, message });
    return;
  }
  const { email, password } = req.body;
  if (!isAuthenticated({ email, password })) {
    const status = 401;
    const message = "Email ou senha incorretos";
    res.status(status).json({ status, message });
    return;
  }
  res.status(200).json({ token: createToken({ email, password }) });
});

server.use(/^(?!\/auth).*$/, (req, res, next) => {
  if (
    req.headers.authorization === undefined ||
    req.headers.authorization.split(" ")[0] !== "Bearer"
  ) {
    const status = 401;
    const message = "Bad authorization header";
    res.status(status).json({ status, message });
    return;
  }
  try {
    verifyToken(req.headers.authorization.split(" ")[1]);
    next();
  } catch (err) {
    const status = 401;
    const message = "Token inválido";
    res.status(status).json({ status, message });
  }
});

server.use(router);
server.listen(process.env.PORT || 3000, () => {
  console.log("JSON Server is running");
});
