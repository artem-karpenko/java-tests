import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;


public class DatatypeConverterTest {
	@Test
	public void testBase64() throws Exception {
		String result = new String(DatatypeConverter.parseBase64Binary("RGVhciBNci4gQXJ0ZW0gS2FycGVua28sDQoNClRoYW5rIHlvdSB2ZXJ5IG11Y2ggZm9yIHlvdXIg" +
"cmVnaXN0cmF0aW9uIGF0IHRoZSBPWFNFRUQgY3VzdG9tZXIgcG9ydGFsLg0KDQpQbGVhc2UgY29u" + 
"ZmlybSB0aGUgc3Vic2NyaXB0aW9uIGJ5IGNsaWNraW5nIG9uIHRoZSBhcHByb3ByaWF0ZSBsaW5r" + 
"IGluIHRoaXMgZS1tYWlsIHRvIGZpbmFsbHkgYWN0aXZhdGUgdGhlIHN1YnNjcmlwdGlvbiBhbmQg" + 
"dG8gY29uZmlybSB0aGUgcmVnaXN0cmF0aW9uOg0KDQpodHRwczovL3BvcnRhbC5wZWludC5sYW4v" + 
"b3hzZWVkLz9jb25maXJtYXRpb25Db2RlPTk4ZDJkMGUwMmM1ZjliYzdmYzMxNTQ1ZWJjZGFlMTc2" + 
"MjhlNzg1MzMmYWRhPW9yZGVycGUNCg0KSWYgY2xpY2tpbmcgdGhlIGxpbmsgYWJvdmUgZG9lcyBu" + 
"b3Qgb3BlbiB5b3VyIGJyb3dzZXIgYW5kIHRha2UgeW91IHRvIG91ciB3ZWIgcGFnZSwgY29weSB0" + 
"aGUgdGV4dCBvZiB0aGUgbGluayBhbmQgcGFzdGUgaXQgaW50byB5b3VyIGJyb3dzZXIuIFdlIHdp" + 
"bGwgdGhlbiByZWRpcmVjdCB5b3UgdG8gb3VyIGN1c3RvbWVyIHBvcnRhbCwgd2hlcmUgeW91IGNh" + 
"biBkaXJlY3RseSBsb2cgaW4uDQoNCkFmdGVyIHRoZSBzdWNjZXNzZnVsIGNvbXBsZXRpb24gb2Yg" + 
"dGhlIHJlZ2lzdHJhdGlvbiB5b3UgY2FuIGxvZyBpbiBlYXNpbHkgYXQgb3VyIGN1c3RvbWVyIHBv" + 
"cnRhbCB2aWEgdGhlIFVSTDogaHR0cHM6Ly9wb3J0YWwub3hzZWVkLm5ldCB1c2luZyB5b3VyIHVz" + 
"ZXIgbmFtZSAnYXJ0ZW1fdTEnIGFuZCBjaG9zZW4gcGFzc3dvcmQuDQoNCkluIHRoZSBjdXN0b21l" + 
"ciBwb3J0YWwsIHlvdSBjYW4gb3JkZXIgb25seSB0aGUgZWRpdGlvbi4gVGhlIHVzZSBvZiBPWFNF" + 
"RUQgb2NjdXJzIHVuZGVyIGEgZGlmZmVyZW50IGxpbmsgdGhhdCB5b3UgcmVjZWl2ZSBieSBlLW1h" + 
"aWwgYWZ0ZXIgY29tcGxldGluZyB5b3VyIHJlZ2lzdHJhdGlvbi4NCg0KSW4gYWRkaXRpb24sIHlv" + 
"dSBvcmRlcmVkIHRoZSBPWFNFRUQgcGVyc29uYWwgZWRpdGlvbi4gQWNjb3JkaW5nbHkgd2Ugc2Vu" + 
"ZCB5b3UgZnVydGhlciBpbmZvcm1hdGlvbiByZWdhcmRpbmcgdGhlIHVzYWdlIG9mIHRoZSBwZXJz" + 
"b25hbCBlZGl0aW9uIGluIGFub3RoZXIgRW1haWwuDQoNCldlbGNvbWUgdG8gT1hTRUVEIQ0KDQpL" + 
"aW5kIHJlZ2FyZHMsDQoNClRoZSBPWFNFRUQgVGVhbQ0KDQpPWFNFRUQgQWt0aWVuZ2VzZWxsc2No" + 
"YWZ0DQpTdWRicmFja3N0cmHDn2UgMTcNCjMzNjExIEJpZWxlZmVsZCwgR2VybWFueQ0KaHR0cDov" + 
"L3d3dy5veHNlZWQuY29tDQoNCkZvbjogKzQ5ICgwKTUyMSA5NzcgOTMzLTANCkZheDogKzQ5ICgw" + 
"KTUyMSA5NzcgOTMzLTExMQ0KbWFpbHRvOiBpbmZvQG94c2VlZC5jb208bWFpbHRvOiUyMGluZm9A" + 
"b3hzZWVkLmNvbT4NCg0KUGxlYXNlIHRoaW5rIGFib3V0IHlvdXIgZW52aXJvbm1lbnRhbCByZXNw" + 
"b25zaWJpbGl0eSBiZWZvcmUgcHJpbnRpbmcgdGhpcyBlbWFpbCENCg0KUmVnaXN0ZXJlZCBPZmZp" + 
"Y2U6IEJpZWxlZmVsZA0KQ29tbWVyY2lhbCBSZWdpc3RlcjogQ291bnR5IENvdXJ0IEJpZWxlZmVs" + 
"ZCBIUkIgMzg4MjINCkV4ZWN1dGl2ZSBCb2FyZDogTWFyY3VzIEhhcnRtYW5uLCBXb2xmZ2FuZyBN" + 
"YWFzDQpTdXBlcnZpc29yeSBCb2FyZDogSnVyZ2VuIEJyaW50cnVwIChDaGFpcm1hbiksIERpZXRl" + 
"ciBCZXJ0cmFtLCBBbGV4YW5kZXIgRmlzY2hlcg0KDQpUaGUgaW5mb3JtYXRpb24gY29udGFpbmVk" + 
"IGluIHRoaXMgbWVzc2FnZSBpcyBjb25maWRlbnRpYWwgb3IgcHJvdGVjdGVkIGJ5IGxhdy4gSWYg" + 
"eW91IGFyZSBub3QgdGhlIGludGVuZGVkIHJlY2lwaWVudCwgcGxlYXNlIGNvbnRhY3QgdGhlIHNl" + 
"bmRlciBhbmQgZGVsZXRlIHRoaXMgbWVzc2FnZS4gQW55IHVuYXV0aG9yaXNlZCBjb3B5aW5nIG9m" + 
"IHRoaXMgbWVzc2FnZSBvciB1bmF1dGhvcmlzZWQgZGlzdHJpYnV0aW9uIG9mIHRoZSBpbmZvcm1h" + 
"dGlvbiBjb250YWluZWQgaGVyZWluIGlzIHByb2hpYml0ZWQuDQo="));
		
		Pattern p = Pattern.compile("confirmationCode=(.+?)&ada=orderpe");
		Matcher m = p.matcher(result);
		m.find();
		System.out.println(m.group(1));
	}
}
