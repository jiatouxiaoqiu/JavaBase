package cn.ebing.dog.api.test;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomTest {

	public static void main(String[] args) {

//		List<String> orderNos = Collections.synchronizedList(new ArrayList<>());
//		IntStream.range(0,8000).parallel().forEach(i->{
//			orderNos.add(generateOrderNo());
//		});
//
//		List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());
//
//		System.out.println("生成订单数："+orderNos.size());
//		System.out.println("过滤重复后订单数："+filterOrderNos.size());
//		System.out.println("重复订单数："+(orderNos.size()-filterOrderNos.size()));

		System.out.println("getLocalIpSuffix："+ getLocalIpSuffix());


//		String a = getYYMMDDHHNumber("xx");
//		System.out.println(a);

	}

	/**
	 * OD单号生成
	 * 订单号生成规则：OD + yyMMddHHmmssSSS + 5位数(商户ID3位+随机数2位) 22位
	 */
	public static String getYYMMDDHHNumber(String merchId){
		StringBuffer orderNo = new StringBuffer(new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()));
		if(StringUtils.isNotBlank(merchId)){
			if(merchId.length()>3){
				orderNo.append(merchId.substring(0,3));
			}else {
				orderNo.append(merchId);
			}
		}
		int orderLength = orderNo.toString().length();
		String randomNum = getRandomByLength(20-orderLength);
		orderNo.append(randomNum);
		return orderNo.toString();
	}


	/** 生成指定位数的随机数 **/
	public static String getRandomByLength(int size){
		if(size>8 || size<1){
			return "";
		}
		Random ne = new Random();
		StringBuffer endNumStr = new StringBuffer("1");
		StringBuffer staNumStr = new StringBuffer("9");
		for(int i=1;i<size;i++){
			endNumStr.append("0");
			staNumStr.append("0");
		}
		int randomNum = ne.nextInt(Integer.valueOf(staNumStr.toString()))+Integer.valueOf(endNumStr.toString());
		return String.valueOf(randomNum);
	}

	/** 订单号生成(NEW) **/
	private static final AtomicInteger SEQ = new AtomicInteger(1000);
	private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmssSS");
	private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");
	public static String generateOrderNo(){
		LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
		if(SEQ.intValue()>9990){
			SEQ.getAndSet(1000);
		}
		return  dataTime.format(DF_FMT_PREFIX)+SEQ.getAndIncrement();
	}

	private volatile static String IP_SUFFIX = null;
	private static String getLocalIpSuffix (){
		if(null != IP_SUFFIX){
			return IP_SUFFIX;
		}
		try {
			synchronized (RandomTest.class){
				if(null != IP_SUFFIX){
					return IP_SUFFIX;
				}
				InetAddress addr = InetAddress.getLocalHost();
				System.out.println("addr" + addr);
				//  172.17.0.4  172.17.0.199 ,
				String hostAddress = addr.getHostAddress();
				System.out.println("hostAddress" + hostAddress);
				if (null != hostAddress && hostAddress.length() > 4) {
					String ipSuffix = hostAddress.trim().split("\\.")[3];
					if (ipSuffix.length() == 2) {
						IP_SUFFIX = ipSuffix;
						return IP_SUFFIX;
					}
					ipSuffix = "0" + ipSuffix;
					IP_SUFFIX = ipSuffix.substring(ipSuffix.length() - 2);
					return IP_SUFFIX;
				}
				IP_SUFFIX = RandomUtils.nextInt(10, 20) + "";
				return IP_SUFFIX;
			}
		}catch (Exception e){
			System.out.println("获取IP失败:"+e.getMessage());
			IP_SUFFIX =  RandomUtils.nextInt(10,20)+"";
			return IP_SUFFIX;
		}
	}

}
