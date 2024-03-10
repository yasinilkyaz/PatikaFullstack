import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Coffee from "./pages/Coffee";
import Post from "./pages/Post";
import AddPost from "./pages/AddPost";
import { QueryProvider } from "./queries/useQuery";

function App() {
  return (
    <>
      <QueryProvider>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Coffee />} />
            <Route path="/coffee" element={<Coffee />} />
            <Route path="/posts" element={<Post />} />
            <Route path="/add-post" element={<AddPost />} />
          </Routes>
        </BrowserRouter>
      </QueryProvider>
    </>
  );
}

export default App;
