# Data structures best practices

- ***Choose the right type of Java data structure based on usage patterns***
    - Required to grow
    - Are duplicates allowed
    - Is ordering important
    - Inserts at the end only or any arbitrary position
    - Concurrently accessed or not
- ***Favor unmodifiable data structures where applicable***
```java
class Match {
    // ...
    public Set<Player> getPlayers() {
        return Collections.unmodifiableSet(this.players);
    }
    // ...
}
```
- ***Thread-safety considerations of the Java data structures***
    - If accessed by a single thread, synchronization is not required, 
    and arrays, lists, sets, stacks, etc. can be used as a local variable.
    - use data structures in a thread unsafe manner, for example declaring 
    it as an instance or static variable.
    - If accessed by multiple threads, prefer a concurrent collection 
    like a copy-on-write lists and sets, concurrent maps, etc. over a 
    synchronized collection for a more optimized concurrent access.
- ***Performance and memory considerations***
    - Initialize your collection with an appropriate initial capacity to 
    minimize the number of times it has to grow for lists and sets, 
    and number of times it has to grow and rehash for maps.
    - Favor concurrent structures like ConcurrentHashMap, CopyOnWrite 
    Lists/Sets, etc. that allow concurrent reads. Use copy-on-write 
    classes and concurrent maps for better scalability.
```java
class Test {
    // ...
    var list = new ArrayList<String>(40);
    var map = new HashMap<String, String>(40);
    // ...
    var list = new CopyOnWriteArrayList<Integer>(); 
    // ...
}
```
- ***Code to interface & use generics***
    - Easier to swap implementation from ArrayList to LinkedList if you 
    code to interface. Generics improve readability.
- ***Properly implement `equals()` and `hashCode()`***
    - Incorrect implementations of `equals()` and `hashCode()` methods 
    can result in data being lost in Maps and Sets. You can also get 
    intermittent data related problems that are harder to consistently 
    reproduce over time.
- ***Use immutable keys***
    - Generally you use `Integer` or `String` class as the key, which are 
    immutable Java objects. If you define your own key class, then it is a 
    best practice to make the key class an immutable object. If you want to 
    insert a new key, then you will always have to instantiate a new object 
    as you cannot modify an immutable object.
- ***Return zero length collections or arrays***
    - As opposed to returning a null in the context of the fetched list is 
    actually empty. Returning a null instead of a zero length collection is 
    more error prone.
- ***Use Stream***
