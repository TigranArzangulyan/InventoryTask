**Inventory System Overview**
For the base of the inventory system, I have chosen to implement a HashMap where the keys represent the items, and the values indicate the count of each item in the inventory. This approach offers fast lookups and ensures that items are stored efficiently.

However, one limitation of this implementation arises when upgrading items: without a reference (pointer) to an item, it becomes difficult to upgrade it. To address this, I have implemented a function, upgradeAll(), which takes only one Item that has to be upgraded, others will be identified and upgraded.
**Upgrade Mechanism**
The upgrade functionality has been implemented with polymorphism to accommodate different upgrade scenarios. The first version of the upgrade function accepts three arguments and is used for all items except those of epic rarity. The second version of upgrade accepts two arguments and is reserved for items of epic rarity.

**Demonstration**
In the provided main.class, three Item objects are instantiated with pointers, and five additional items are generated randomly. Following this, the specified item is automatically upgraded, and the results are displayed.

**Design Considerations**
The system has been designed with a focus on performance, specifically optimizing for constant time (O(1)) operations for adding and upgrading items, except in cases where automatic upgrades are triggered. While the design prioritizes speed, it does introduce limitations in terms of accessibility to individual items within the inventory. Items marked for deletion are not physically removed but are instead hidden, allowing for potential future use.