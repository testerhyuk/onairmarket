import { lazy, Suspense } from "react";
import { createBrowserRouter } from "react-router-dom";

const Main = lazy(() => import('../pages/home/MainPage'))
const FetchingModal = 'Loading...'

const root = createBrowserRouter([
    {
        path: '',
        element: <Suspense fallback={<FetchingModal />}><Main /></Suspense>
    }
])

export default root;