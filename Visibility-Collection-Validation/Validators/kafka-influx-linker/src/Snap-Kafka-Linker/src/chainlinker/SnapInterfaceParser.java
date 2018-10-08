package chainlinker;

public class SnapInterfaceParser extends SnapPluginParser {
	public SnapInterfaceParser() {
		super();
		// All these data forms must be updated when snap publisher's output format is changed.
		
		// Pattern: /intel/procfs/iface/(alphanumerical(lowercase only) or _ or . or -)/(bytes_recv or bytes_sent or compressed_recv or compressed_sent or drop_recv or drop_sent or errs_recv or errs_sent or fifo_recv or fifo_sent or frame_recv or frame_sent or multicast_recv or multicast_sent or packets_recv or packets_sent)
		regexTypeMap.put("^\\/intel\\/procfs\\/iface\\/([0-9]|[a-z]|_|\\.|-)*\\/(bytes_recv|bytes_sent|compressed_recv|compressed_sent|drop_recv|drop_sent|errs_recv|errs_sent|fifo_recv|fifo_sent|frame_recv|frame_sent|multicast_recv|multicast_sent|packets_recv|packets_sent)$", lClass);
		
		regexSet = regexTypeMap.keySet();	
	}
}
