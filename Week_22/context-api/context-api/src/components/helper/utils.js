export function findItemById(items, id) {
    for (let i = 0; i < items.length; i++) {
        const item = items[i];
        if (item.id === id) {
            return item;
        }
        if (item.subItems && item.subItems.length > 0) {
            const foundItem = findItemById(item.subItems, id);
            if (foundItem) {
                return foundItem;
            }
        }
    }
    return undefined;
}