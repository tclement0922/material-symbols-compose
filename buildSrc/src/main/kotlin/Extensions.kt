import java.util.Properties

fun Properties.getString(key: String) = get(key) as? String ?: error("'$key' key not found in the properties file")