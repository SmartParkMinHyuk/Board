package project.common.config;

import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {

	String domainInfo;
	String nasInfo;
	String nasPath;
	String cryptoKey;
	String originalImagePath;
	String thumbnailImagePath;
	
	int defaultPagingSize;
	int defaultListViewSize;
	int mobileDefaultListSize;
	
	public String getDomainInfo() {
		return domainInfo;
	}
	public void setDomainInfo(String domainInfo) {
		this.domainInfo = domainInfo;
	}
	public String getNasInfo() {
		return nasInfo;
	}
	public void setNasInfo(String nasInfo) {
		this.nasInfo = nasInfo;
	}
	public String getNasPath() {
		return nasPath;
	}
	public void setNasPath(String nasPath) {
		this.nasPath = nasPath;
	}
	public String getCryptoKey() {
		return cryptoKey;
	}
	public void setCryptoKey(String cryptoKey) {
		this.cryptoKey = cryptoKey;
	}
	public String getOriginalImagePath() {
		return originalImagePath;
	}
	public void setOriginalImagePath(String originalImagePath) {
		this.originalImagePath = originalImagePath;
	}
	public String getThumbnailImagePath() {
		return thumbnailImagePath;
	}
	public void setThumbnailImagePath(String thumbnailImagePath) {
		this.thumbnailImagePath = thumbnailImagePath;
	}
	public int getDefaultPagingSize() {
		return defaultPagingSize;
	}
	public void setDefaultPagingSize(int defaultPagingSize) {
		this.defaultPagingSize = defaultPagingSize;
	}
	public int getDefaultListViewSize() {
		return defaultListViewSize;
	}
	public void setDefaultListViewSize(int defaultListViewSize) {
		this.defaultListViewSize = defaultListViewSize;
	}
	public int getMobileDefaultListSize() {
		return mobileDefaultListSize;
	}
	public void setMobileDefaultListSize(int mobileDefaultListSize) {
		this.mobileDefaultListSize = mobileDefaultListSize;
	}
}
