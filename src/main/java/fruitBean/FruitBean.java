package fruitBean;


import fruitEntity.Fruit;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Local
public class FruitBean {

    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    public Fruit add(Fruit fruit){
        return em.merge(fruit);
    }

    public Fruit get(long id){
        return em.find(Fruit.class, id);
    }

    public void update(Fruit fruit){
        add(fruit);
    }

    public void delete(long id){
        em.remove(get(id));
    }

    public List<Fruit> getAll(){
        TypedQuery<Fruit> namedQuery = em.createNamedQuery("Fruit.getAll", Fruit.class);
        return namedQuery.getResultList();
    }
}
