package chapter17projectsSwingOne;

public interface Watcher {
	//potential privacy leak
	void notify(Watchable watchable);
	void notify(String news);
}
