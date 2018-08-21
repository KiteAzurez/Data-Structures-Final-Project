
public class BSTree<E extends Comparable<E>>
{
	public TreeNode<E> root;
	public TreeNode<E> current;

	public void inOrderTranverse(TreeNode<E> root)
	{
		if(root != null){
			inOrderTranverse(root.getWest());
			System.out.println(root.getData());
			inOrderTranverse(root.getEast());
		}
	}


	public void add(E data)
	{
		boolean fine = false;

		if(root == null)
			root = new TreeNode<E>(data, null, null);

		current = root;

		do {
		if(current.getData().compareTo(data) > 0)
		{
			if(current.getWest() == null)
			{
				current.setWest(new TreeNode<>(data, null, null));
				fine = true;
			}
			else
				current = current.getWest();
		}
		else
		{
			if (current.getEast() == null)
			{
				current.setEast(new TreeNode<E>(data, null,null));
				fine = true;
			}
			else
				current = current.getEast();

		}
	} while(!fine);
	}

	public boolean remove(E target)
	{
		TreeNode<E> mainCurr = null;
		current = root;
		while(current!= null && target != current.getData())
		{

			mainCurr = current;
			if (target.compareTo(current.getData()) < 0)
				current = current.getWest();
			else
				current = current.getEast();
		}

		if(current == null)
			return false;

		else if (current.getWest() == null)
		{
			if (mainCurr == null)
				root = current.getEast();
			else if (current == mainCurr.getWest())
				mainCurr.setWest(current.getEast());
			else
				mainCurr.setEast(current.getEast());
			return true;
		}
		else
		{
			current.setData(current.getWest().bestEastData());
			current.setWest(current.getWest().removeBestEast());
			return true;
		}

	}

	public int search(E target)
	{
		int probe = 0;
		current = root;

		if( root == null)
			return probe;
		if(target.compareTo(current.getData()) == 0)
			return probe + 1;
		else if(target.compareTo(current.getData()) < 0)
		{
			current = current.getWest();

		}
		else
		{

			current = current.getEast();
		}
		return probe;


	}

}