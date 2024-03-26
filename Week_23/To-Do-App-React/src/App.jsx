import React, { useState } from 'react';
import "./App.css"

function App() {
  const initialData = {
    todo: [
      { done: true, text: "Learn JavaScript" },
      { done: false, text: "Learn React" },
      { done: false, text: "Have a life!" }
    ]
  };

  const [todos, setTodos] = useState(initialData.todo);
  const [newTodo, setNewTodo] = useState('');
  const [activeFilter, setActiveFilter] = useState('all');

  const addTodo = (e) => {
    e.preventDefault();
    if (newTodo.trim() !== '') {
      setTodos([...todos, { done: false, text: newTodo }]);
      setNewTodo('');
    }
  };

  const deleteTodo = (index) => {
    const updatedTodos = todos.filter((todo, i) => i !== index);
    setTodos(updatedTodos);
  };

  const toggleDone = (index) => {
    const updatedTodos = todos.map((todo, i) => {
      if (i === index) {
        return { ...todo, done: !todo.done };
      }
      return todo;
    });
    setTodos(updatedTodos);
  };

  const clearCompleted = () => {
    const filteredTodos = todos.filter(todo => !todo.done);
    setTodos(filteredTodos);
  };

  const handleFilter = (filter) => {
    setActiveFilter(filter);
  };

  const filteredTodos = activeFilter === 'all' ? todos : activeFilter === 'active' ? todos.filter(todo => !todo.done) : todos.filter(todo => todo.done);

  return (
    <section className="todoapp">
      <header className="header">
        <h1>todos</h1>
        <form onSubmit={addTodo}>
          <input className="new-todo" placeholder="What needs to be done?" value={newTodo} onChange={(e) => setNewTodo(e.target.value)} autoFocus />
        </form>
      </header>
      <section className="main">
        <ul className="todo-list">
          {filteredTodos.map((todo, index) => (
            <li key={index} className={todo.done ? 'completed' : ''}>
              <div className="view">
                <input className="toggle" type="checkbox" checked={todo.done} onChange={() => toggleDone(index)} />
                <label>{todo.text}</label>
                <span className="destroy" onClick={() => deleteTodo(index)}></span>
              </div>
            </li>
          ))}
        </ul>
      </section>
      <footer className="footer">
        <span className="todo-count">{todos.filter(todo => !todo.done).length} {todos.filter(todo => !todo.done).length === 1 ? 'item' : 'items'} left</span>
        <ul className="filters">
          <li>
            <a className={activeFilter === 'all' ? 'selected' : ''} onClick={() => handleFilter('all')}>All</a>
          </li>
          <li>
            <a className={activeFilter === 'active' ? 'selected' : ''} onClick={() => handleFilter('active')}>Active</a>
          </li>
          <li>
            <a className={activeFilter === 'completed' ? 'selected' : ''} onClick={() => handleFilter('completed')}>Completed</a>
          </li>
        </ul>
        <span className="clear-completed" onClick={clearCompleted}>Clear completed</span>
      </footer>
    </section>
  );
}

export default App;
