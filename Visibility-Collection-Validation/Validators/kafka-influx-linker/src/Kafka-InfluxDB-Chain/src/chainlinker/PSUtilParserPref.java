package chainlinker;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced site: https://blog.seotory.com/post/2016/03/java-singleton-pattern
/*
 * Preferences for SnapPSUtilParser class
 */

public class PSUtilParserPref {
	private static PSUtilParserPref instance = new PSUtilParserPref();

	@SuppressWarnings("rawtypes")
	private HashMap<String, Class> TypeMap_internal;
	@SuppressWarnings("rawtypes")
	public Map<String, Class> TypeMap;

	private PSUtilParserPref () {		
		TypeMap_internal = new HashMap<>();
		Long lValue = 0L;
		Double lfValue = 0.0;
		@SuppressWarnings("rawtypes")
		Class lClass = lValue.getClass();
		@SuppressWarnings("rawtypes")
		Class lfClass = lfValue.getClass();

		// PSUtilParser's every settings must be written here.

		/*
		 * TypeMap is introduced because just parsing data JSON may lead to data type problem.
		 * Especially for "intel/psutil/load~" datas. They're given in form of fraction, usually,
		 * but sometimes the value may be exact integer. Then it will cause an exception to InfluxDB
		 * library and the program will be shut down.
		 * 
		 * Therefore I amended to record all of each data's usual data type. Of course, the list must
		 * be updated when a data not within the list must be collected. 
		 */

		// TypeMap : Key = String of the measurement from InfluxDB, Value = Data class for its field
		TypeMap_internal.put("intel/psutil/load/load1", lfClass);
		TypeMap_internal.put("intel/psutil/load/load5", lfClass);
		TypeMap_internal.put("intel/psutil/load/load15", lfClass);
		TypeMap_internal.put("intel/psutil/vm/free", lClass);
		TypeMap_internal.put("intel/psutil/vm/used", lClass);
		TypeMap_internal.put("intel/psutil/vm/available", lClass);
		// Setting part ends

		this.TypeMap = Collections.unmodifiableMap(TypeMap_internal);
	}

	public static PSUtilParserPref getInstance () {
		return instance;
	}	
}
