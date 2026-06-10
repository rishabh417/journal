package com.rishabh.journal.repository;

import com.rishabh.journal.entity.ConfigJournalAppEntity;
import com.rishabh.journal.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {




}
