export function findItemById(items, id) {
    let foundItem = items.find((item) => item.id === id);
    
    if (!foundItem) {
        for (const item of items) {
            if (item.subItems && item.subItems.length > 0) {
                foundItem = findItemById(item.subItems, id);
                if (foundItem) {
                    break;
                }
            }
        }
    }
    
    return foundItem;
}