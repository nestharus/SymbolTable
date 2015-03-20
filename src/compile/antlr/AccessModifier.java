package compile.antlr;

import java.util.HashSet;

/*
 * AccessModifier
 * 
 * public AccessModifier()
 * 
 * public static AccessModifier intersect(AccessModifier... modifiers)
 * public static AccessModifier union(AccessModifier... modifiers)
 * 
 * public static AccessModifier contextIntersect(AccessModifier modifier, Object accessor, Object accessed)
 * -	contextual intersection based on the state of two objects
 * -	run after a standard intersection
 * 
 * protected boolean intersect(Object accessor, Object accessed)
 * -	controls whether a contextual intersection will succeed or not given
 * -	two objects
 * 
 * public boolean isEmpty()
 * -	are there any access modifiers?
 * 
 * public boolean equals(AccessModifier accessModifier)
 * 
 * public boolean containsAll(AccessModifier accessModifier)
 * -	If this contains all keys from accessModifier, accessModifier
 * -	is accessible by this
 */

public class AccessModifier
{
	private final HashSet<AccessModifier>	mask;

	public AccessModifier()
	{
		mask = new HashSet<AccessModifier>();
		mask.add(this);
	} // AccessMask

	public static AccessModifier createSet()
	{
		AccessModifier set = new AccessModifier();

		set.mask.remove(set);

		return set;
	} // createSet

	public static AccessModifier contextIntersect(AccessModifier modifier, Object accessor, Object accessed)
	{
		AccessModifier intersection = createSet();

		if (modifier == null || accessor == null || accessed == null)
		{
			return intersection;
		} // if

		for (AccessModifier mod : modifier.mask)
		{
			if (mod.contextIntersect(accessor, accessed))
			{
				intersection.mask.add(mod);
			} // if
		} // for

		return intersection;
	} // intersect

	// used for special cases where a simple intersection will not work
	//
	// example: two objects share some region with each other
	protected boolean contextIntersect(Object accessor, Object accessed)
	{
		return true;
	} // intersect

	public static AccessModifier intersect(AccessModifier... modifiers)
	{
		AccessModifier intersection = union(modifiers);

		for (AccessModifier modifier : modifiers)
		{
			if (modifier == null)
			{
				intersection.mask.clear();

				break;
			} // if

			intersection.mask.retainAll(modifier.mask);
		} // for

		return intersection;
	} // intersect

	public static AccessModifier union(AccessModifier... modifiers)
	{
		AccessModifier union = createSet();

		for (AccessModifier modifier : modifiers)
		{
			if (modifier != null)
			{
				union.mask.addAll(modifier.mask);
			} // if
		} // for

		return union;
	} // union

	public boolean equals(AccessModifier accessModifier)
	{
		if (accessModifier == null)
		{
			return false;
		} // if

		return containsAll(accessModifier) && accessModifier.containsAll(this);
	} // accessModifier

	public boolean isEmpty()
	{
		return mask.isEmpty();
	} // isEmpty

	public boolean containsAll(AccessModifier accessModifier)
	{
		if (accessModifier == null)
		{
			return true;
		} // if

		return mask.containsAll(accessModifier.mask);
	} // isAccessible
} // AccessMask
