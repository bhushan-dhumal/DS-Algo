void merge_sort(int a[], int N)
{
	if(N>1)
	{
		int m = N/2;
		int n1 = m;
		int n2 = N-m;
		int left[n1];
		int right[n2];
		int i,j,k;
	
		for(i =0;i<n1;i++)
		{
				left[i]=a[i];
		}
		for(i=0;i<n2;i++)
		{
				right[i]=a[m+i];
		}

		merge_sort(left,n1);
		merge_sort(right,n2);

		i=j=k=0;
		while(i< n1 && j < n2)
		{
		if(left[i] < right[j])
			a[k] = left[i++];
		else
			a[k] = right[j++];
		k++;
		}
		while(i<n1)
			a[k++] = left[i++];
		while(j<n2)
			a[k++] = right[j++];
	}
}

int main()
{
	int N = 10;
	int a[N] = {10,9,8,7,6,5,4,3,2,1};

	merge_sort(a,N);
	cout<<"Final Output"<<"\n";
	int i;
	for(i =0;i<N;i++)
	{
		cout<<a[i] <<"\t";
	}
}
