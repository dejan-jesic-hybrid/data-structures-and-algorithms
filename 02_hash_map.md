# Data structures

## Hash map

- Iteration through the hash map is in 'random' order.
- Time taken to retrieve item from hash map by it's key would be the same
for big sized hash maps.
- When hash map is instantiated, java creates array of 16 elements. When 
you add item to the hash map java converts key to integer value and then
takes module of that integer when it's divided by 16 (initial size of 
hash map). Every object has hashCode() it's inherited from 
`java.lang.Object` so java uses that method to determine hash code of 
the key. So hash map can contain 4 items in the same bucket 
(etc. module == 4).
- Each bucket contains linked list.
- Default size of hash map is 16, and default factor is 0.75. When hash 
map is populated by 75% (3/4 of the buckets have 1+ elements within 
them) then the hash map is considered to getting full so it's resized 
(x2).
- Default size and factor can be specified when hash map is created via 
constructor parameter.
- If we want some object to be the key of the map entry, we need to 
implement hashCode() and equals() methods. We should not rely on default
implementation of hashCode() since java will return the same value for 
two objects only if they physically are same objects in memory.

![hash map bucket](images/hash-map-bucket.png)

![hash map hash code](images/hash-map-hash-code.png)

![hash map resizing](images/hash-map-resizing.png)

## Linked hash map

- Extends HashMap. 
- Iteration through the linked hash map is in defined order, items can 
be retrieved in the same order they were added.
