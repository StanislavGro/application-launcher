package com.launcher.api;

public class QuantityEqualsHashCode {

//    protected <T> void assertEqualityConsistency(
//            Class<T> clazz,
//            T entity) {
//
//        Set<T> tuples = new HashSet<>();
//
//        assertFalse(tuples.contains(entity));
//        tuples.add(entity);
//        assertTrue(tuples.contains(entity));
//
//        doInJPA(entityManager -> {
//            entityManager.persist(entity);
//            entityManager.flush();
//            assertTrue(
//                    "The entity is not found in the Set after it's persisted.",
//                    tuples.contains(entity)
//            );
//        });
//
//        assertTrue(tuples.contains(entity));
//
//        doInJPA(entityManager -> {
//            T entityProxy = entityManager.getReference(
//                    clazz,
//                    entity.getId()
//            );
//            assertTrue(
//                    "The entity proxy is not equal with the entity.",
//                    entityProxy.equals(entity)
//            );
//        });
//
//        doInJPA(entityManager -> {
//            T entityProxy = entityManager.getReference(
//                    clazz,
//                    entity.getId()
//            );
//            assertTrue(
//                    "The entity is not equal with the entity proxy.",
//                    entity.equals(entityProxy));
//        });
//
//        doInJPA(entityManager -> {
//            T _entity = entityManager.merge(entity);
//            assertTrue(
//                    "The entity is not found in the Set after it's merged.",
//                    tuples.contains(_entity)
//            );
//        });
//
//        doInJPA(entityManager -> {
//            entityManager.unwrap(Session.class).update(entity);
//            assertTrue(
//                    "The entity is not found in the Set after it's reattached.",
//                    tuples.contains(entity)
//            );
//        });
//
//        doInJPA(entityManager -> {
//            T _entity = entityManager.find(clazz, entity.getId());
//            assertTrue(
//                    "The entity is not found in the Set after it's loaded in a different Persistence Context.",
//                    tuples.contains(_entity)
//            );
//        });
//
//        doInJPA(entityManager -> {
//            T _entity = entityManager.getReference(clazz, entity.getId());
//            assertTrue(
//                    "The entity is not found in the Set after it's loaded as a proxy in a different Persistence Context.",
//                    tuples.contains(_entity)
//            );
//        });
//
//        T deletedEntity = doInJPA(entityManager -> {
//            T _entity = entityManager.getReference(
//                    clazz,
//                    entity.getId()
//            );
//            entityManager.remove(_entity);
//            return _entity;
//        });
//
//        assertTrue(
//                "The entity is not found in the Set even after it's deleted.",
//                tuples.contains(deletedEntity)
//        );
//    }

}
