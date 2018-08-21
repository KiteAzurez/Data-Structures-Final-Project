class TreeNode<E extends Comparable<E>>
{
	private E data;
	private TreeNode<E> west;
	private TreeNode<E> east;



	public TreeNode(E inData, TreeNode<E> inWest, TreeNode<E> inEast)
	{
		data = inData;
		west = inWest;
		east = inEast;

	}
	public E getData()
	{
		return data;
	}

	public TreeNode<E> getWest()
	{
		return west;
	}
	public E bestWestData()
	{
		if(west == null)
			return data;
		else
			return west.bestWestData();
	}

	public TreeNode<E> getEast()
	{
		return east;
	}
	public E bestEastData()
	{
		if(east == null)
			return data;
		else
			return east.bestEastData();
	}

	public TreeNode<E> removeBestWest()
	{
		if(west == null)
		{
			return east;
		}
		else
		{
			west = west.removeBestWest();
			return this;
		}
	}
	public TreeNode<E> removeBestEast()
	{
		if(east == null)
		{
			return west;
		}
		else
		{
			east = east.removeBestEast();
			return this;
		}
	}

	public void alphaOrder(TreeNode<E> node)
    	{


    		if(node == null)
    			System.out.println("Done");
    		alphaOrder(node.getWest());
    		System.out.print(node.getData() + " ");
    		alphaOrder(node.getEast());
    	}






	public boolean isLeaf()
	{
		return (west == null) && (east == null);
	}

	public void setData(E newData)
	{
		data = newData;
	}
	public void setWest(TreeNode<E> newWest)
	{
		west = newWest;
	}

	public void setEast(TreeNode<E> newEast)
	{
		east = newEast;
	}


}