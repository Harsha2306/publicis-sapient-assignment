import { BrowserRouter, Route, Routes } from "react-router";
import Home from "./pages/Home";
import Recipe from "./components/Recipe";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/recipe/:id" element={<Recipe />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
