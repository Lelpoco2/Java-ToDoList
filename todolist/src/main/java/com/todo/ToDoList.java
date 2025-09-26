package com.todo;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonParseException;

public class ToDoList {
	private final List<Task> tasks;

	public ToDoList() {
		this.tasks = new ArrayList<>();
	}

	public void addTask(Task task) {
		tasks.add(task);
		this.saveToFile("tasks.json");
	}

	public boolean removeTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.remove(index);
			this.saveToFile("tasks.json");
			return true;
		}
		return false;
	}

	public List<Task> getTasks() {
	this.loadFromFile("tasks.json");
	return new ArrayList<>(tasks);
	}


	public Task getTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			return tasks.get(index);
		}
		return null;
	}


	public List<Task> getComplitedTasks() {
		this.loadFromFile("tasks.json");
		List<Task> completedTasks = new ArrayList<>();
		for (Task task : tasks) {
			if (task.isCompleted()) {
				completedTasks.add(task);
			}
		}
		return completedTasks;
	}


	public List<Task> getPendingTasks() {
		this.loadFromFile("tasks.json");
		List<Task> pendingTasks = new ArrayList<>();
		for (Task task : tasks) {
			if (!task.isCompleted()) {
				pendingTasks.add(task);
			}
		}
		return pendingTasks;
	}

	public boolean markTaskCompleted(int index) {
		Task task = getTask(index);
		if (task != null) {
			task.setCompleted(true);
			this.saveToFile("tasks.json");
			return true;
		}
		return false;
	}

	public int size() {
		return tasks.size();
	}

	// Custom Gson instance with LocalDateTime adapter
	private static Gson buildGson() {
		JsonSerializer<LocalDateTime> serializer = (src, typeOfSrc, context) -> new JsonPrimitive(src.toString());
		JsonDeserializer<LocalDateTime> deserializer = (json, typeOfT, context) -> {
			try {
				return LocalDateTime.parse(json.getAsString());
			} catch (Exception e) {
				throw new JsonParseException(e);
			}
		};
		return new GsonBuilder()
			.registerTypeAdapter(LocalDateTime.class, serializer)
			.registerTypeAdapter(LocalDateTime.class, deserializer)
			.create();
	}

	// Save tasks to JSON file
	public boolean saveToFile(String filename) {
		Gson gson = buildGson();
		try (FileWriter writer = new FileWriter(filename)) {
			gson.toJson(tasks, writer);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Load tasks from JSON file
	public boolean loadFromFile(String filename) {
		Gson gson = buildGson();
		Type taskListType = new TypeToken<ArrayList<Task>>(){}.getType();
		try (FileReader reader = new FileReader(filename)) {
			List<Task> loadedTasks = gson.fromJson(reader, taskListType);
			if (loadedTasks != null) {
				tasks.clear();
				tasks.addAll(loadedTasks);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
