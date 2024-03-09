package asioso.main.model;

public class Meta {
	    private int count;
	    private int start;
	    private int limit;
	    private String sort;
	    private String order;
	    private String next_link;
	    private String previous_link;
	    
	    public Meta () {
	    }

		public Meta(int count, int start, int limit, String sort, String order, String next_link,
				String previous_link) {
			super();
			this.count = count;
			this.start = start;
			this.limit = limit;
			this.sort = sort;
			this.order = order;
			this.next_link = next_link;
			this.previous_link = previous_link;
		}

		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getLimit() {
			return limit;
		}
		public void setLimit(int limit) {
			this.limit = limit;
		}
		public String getNext_link() {
			return next_link;
		}
		public void setNext_link(String next_link) {
			this.next_link = next_link;
		}

		public String getPrevious_link() {
			return previous_link;
		}

		public void setPrevious_link(String previous_link) {
			this.previous_link = previous_link;
		}

		public String getSort() {
			return sort;
		}

		public String getOrder() {
			return order;
		}

		public void setOrder(String order) {
			this.order = order;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}

		
	    

}
