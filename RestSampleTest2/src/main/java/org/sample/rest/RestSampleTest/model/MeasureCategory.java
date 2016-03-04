package org.sample.rest.RestSampleTest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "MeasureCategory", schema = "dbo", catalog = "ujwaltest")
@XmlRootElement
public class MeasureCategory {


		private int measureCategoryIdentifier;
		private String categoryName;
		private String categoryCode;
		private String categoryDescription;
		private Date recordLoadDatetime;
		private Date recordLastUpdateDatetime;

		public MeasureCategory() {
		}

		public MeasureCategory(int measureCategoryIdentifier, String categoryName, String categoryCode,
				Date recordLoadDatetime, Date recordLastUpdateDatetime) {
			this.measureCategoryIdentifier = measureCategoryIdentifier;
			this.categoryName = categoryName;
			this.categoryCode = categoryCode;
			this.recordLoadDatetime = recordLoadDatetime;
			this.recordLastUpdateDatetime = recordLastUpdateDatetime;
		}

		public MeasureCategory(int measureCategoryIdentifier, String categoryName, String categoryCode,
				String categoryDescription, Date recordLoadDatetime, Date recordLastUpdateDatetime) {
			this.measureCategoryIdentifier = measureCategoryIdentifier;
			this.categoryName = categoryName;
			this.categoryCode = categoryCode;
			this.categoryDescription = categoryDescription;
			this.recordLoadDatetime = recordLoadDatetime;
			this.recordLastUpdateDatetime = recordLastUpdateDatetime;
		}

		@Id

		@Column(name = "MeasureCategoryIdentifier", unique = true, nullable = false)
		public int getMeasureCategoryIdentifier() {
			return this.measureCategoryIdentifier;
		}

		public void setMeasureCategoryIdentifier(int measureCategoryIdentifier) {
			this.measureCategoryIdentifier = measureCategoryIdentifier;
		}

		@Column(name = "CategoryName", nullable = false, length = 500)
		public String getCategoryName() {
			return this.categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		@Column(name = "CategoryCode", nullable = false, length = 10)
		public String getCategoryCode() {
			return this.categoryCode;
		}

		public void setCategoryCode(String categoryCode) {
			this.categoryCode = categoryCode;
		}

		@Column(name = "CategoryDescription", length = 1000)
		public String getCategoryDescription() {
			return this.categoryDescription;
		}

		public void setCategoryDescription(String categoryDescription) {
			this.categoryDescription = categoryDescription;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "RecordLoadDatetime", nullable = false, length = 23)
		public Date getRecordLoadDatetime() {
			return this.recordLoadDatetime;
		}

		public void setRecordLoadDatetime(Date recordLoadDatetime) {
			this.recordLoadDatetime = recordLoadDatetime;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "RecordLastUpdateDatetime", nullable = false, length = 23)
		public Date getRecordLastUpdateDatetime() {
			return this.recordLastUpdateDatetime;
		}

		public void setRecordLastUpdateDatetime(Date recordLastUpdateDatetime) {
			this.recordLastUpdateDatetime = recordLastUpdateDatetime;
		}

	}


