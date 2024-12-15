import './App.css';
import { RouterProvider } from 'react-router-dom';
import root from './router/root';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className='root'>
      <RouterProvider router={root} />
    </div>
  );
}

export default App;
