package store;

import entities.Bird;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BirdStore extends AbstractBirdStore {

    private static BirdStore BIRD_STORE = new BirdStore();;
    private ConcurrentHashMap<Integer, List<Bird>> birdList = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<Bird>> birdByArea = new ConcurrentHashMap<>();

    public static BirdStore birdStore() {
        return BIRD_STORE;
    }


    public BirdStore() {

    }

    @Override
    public void addBird(Bird b) {
        birdList.computeIfAbsent(b.getId(), v -> Collections.synchronizedList(new ArrayList<Bird>()));
        System.out.println("Bird With id .... already exists");

        birdByArea.computeIfAbsent(b.getLivingArea(), z -> Collections.synchronizedList(new ArrayList<Bird>()));

//        if (birdList.computeIfAbsent(b.getId(), v -> birds)) {
//            birdByName.putIfAbsent(b.getName(), b);
//            //если ареал существует в хранилище, то добавляем птицу в список
//            if (birdByArea.containsKey(b.getLivingArea())) {
//                List<Bird> birds = birdByArea.get(b.getLivingArea());
//                birds.add(b);
//            } else {
//                birdByArea.put(b.getLivingArea(), new ArrayList<Bird>());
//            }
//
//        } else {
//            System.out.println("Bird With name .... already exists");
//        }
    }

    @Override
    public List<Bird> searchByName(String nameToSearch) {

     return birdList.get(nameToSearch);
    }


    @Override
    public List<Bird> searchByLivingArea(String livingAreaToFind) {
        return birdByArea.get(livingAreaToFind);
    }

    @Override
    public void deleteBird(Integer id) {
        birdList.remove(id);
    }
}
