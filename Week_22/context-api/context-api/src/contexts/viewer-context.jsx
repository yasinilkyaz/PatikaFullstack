import { createContext, useContext, useState } from "react";
import { content } from '../data'

const Context = createContext(undefined);

export const ViewerProvider = ({ children }) => {
    const [list, setList] = useState(content);
    const [activeFolderId, setActiveFolderId] = useState("1");
    const [backFolderId, setbackFolderId] = useState("null");
    const [selectedId, setSelectedId] = useState("null");

    const changeFolder = (id) => {
        setActiveFolderId(id);
        setbackFolderId(backFolderId);
    };

    const select= (id) => {
        setSelectedId(id);
    };

    const handleBack = () => {
        setbackFolderId(backFolderId);
    };

    return (
        <Context.Provider
            value={{
                list,
                activeFolderId,
                setActiveFolderId,
                changeFolder,
                backFolderId,
                selectedId,
                setSelectedId,
                select,
                handleBack
            }}
        >
            {children}
        </Context.Provider>
    );
};

export const UseViewerContext = () => {
    const value = useContext(Context);
    if (!value) {
        throw new Error('useContext must be used within a ViewerProvider');
    }
    return value;
};