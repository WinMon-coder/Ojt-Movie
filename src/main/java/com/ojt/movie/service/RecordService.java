package com.ojt.movie.service;

import java.util.List;

import com.ojt.movie.entity.Record;


public interface RecordService {

	public List<Record> getAll();

	public Record get(int id);

	public Record create(Record record);

	public Record update(int id, Record record);

	public boolean delete(int id);

	public List<Record> getAllByUserID(int userID);

}
