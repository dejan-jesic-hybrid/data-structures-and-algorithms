## Hash set

- Hash set is implemented on top of the hash map.

```java
public class HashSet<E> extends AbstractSet<E> 
    implements Set<E>, Cloneable, Serializable {

    ...
    
    private transient HashMap<E,Object> map;
    
    private static final Object PRESENT = new Object();

    ...
    
    public HashSet() {
        map = new HashMap<>();
    }
    
    ...
    
    public boolean contains(Object o) {
        return map.containsKey(o);
    }
    
    ...
    
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
    
    ...
    
}
```
