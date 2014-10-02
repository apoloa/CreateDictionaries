package gui;

public class Counter extends Thread
{
	private static long i;
	private static long max;
	private static boolean start;

	public Counter()
	{
		i = 0;
		max = -1;
		start = false;
	}

	public synchronized static void addMax(int maxim)
	{

		max = max + maxim;
		if (start == false)
		{
			start = true;
		}
	}

	public synchronized static void count()
	{
		i++;

	}

	@Override
	public void run()
	{
		while (!start)
		{
			System.out.println("Esperando datos...");
		}
		while (i < max)
		{
			double tntCiento = ((double) i / (double) max);
			System.out.println("Llevamos " + i + " de " + max + " -----> " + tntCiento * 100.0
					+ "%");
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
